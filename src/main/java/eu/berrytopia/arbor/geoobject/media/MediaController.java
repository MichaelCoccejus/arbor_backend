package eu.berrytopia.arbor.geoobject.media;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static eu.berrytopia.arbor.config.Config.requestMappingPath;

@RestController
@RequestMapping(path = requestMappingPath + "media")
public class MediaController {

    private final MediaService mediaService;


    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public List<Media> getMedia(){ return mediaService.getMedia(); }




}
