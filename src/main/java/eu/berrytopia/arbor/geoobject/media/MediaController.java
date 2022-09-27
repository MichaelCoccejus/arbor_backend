package eu.berrytopia.arbor.geoobject.media;

import eu.berrytopia.arbor.attachment.ResponseData;
import eu.berrytopia.arbor.attachment.entity.Attachment;
import eu.berrytopia.arbor.attachment.service.AttachmentService;
import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.geoobject.GeoObjectService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

import static eu.berrytopia.arbor.config.Config.requestMappingPath;

@RestController
@RequestMapping(path = requestMappingPath + "media")
public class MediaController {

    private final MediaService mediaService;
    private final AttachmentService attachmentService;

    private final GeoObjectService geoObjectService;


    public MediaController(MediaService mediaService, AttachmentService attachmentService, GeoObjectService geoObjectService) {

        this.mediaService = mediaService;
        this.attachmentService = attachmentService;
        this.geoObjectService = geoObjectService;
    }

    @GetMapping
    public List<Media> getMedia(){ return mediaService.getMedia(); }


    @PostMapping
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("objectID") Long objectID ) throws Exception {
        Attachment attachment = null;
        String downloadURl = "";
        attachment = attachmentService.saveAttachment(file);
        String attachmentId = attachment.getId();

        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachmentId)
                .toUriString();

        GeoObject geoObject = geoObjectService.getGeoObject(objectID);

        Media media = new Media();
        media.setAttachmentFull(attachment);
        media.setContentType(file.getContentType());
        media.setGeoObject(geoObject);
        mediaService.addMedia(media);

        geoObject.getMediaSet().add(media);
        geoObjectService.updateGeobject(geoObject);

        return new ResponseData(attachment.getFileName(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }


}
