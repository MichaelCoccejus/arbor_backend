package eu.berrytopia.arbor.geoobject.media;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MediaService {
    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<Media> getMedia() { return mediaRepository.findAll(); }

    public Media getMedia(Long id) {

        Optional<Media> mediaOptional = mediaRepository.findById(id);
        if (!mediaOptional.isPresent()) {
            throw new IllegalStateException("Media with ID " + id + " does not exist");
        }
      return mediaOptional.get();
    }

    public void addMedia(Media media) {
        mediaRepository.save(media);
    }

    public void deleteMedia(Long id) {

        Optional<Media> mediaOptional = mediaRepository.findById(id);
        if (!mediaOptional.isPresent()) {
            throw new IllegalStateException("Media with ID " + id + " does not exist");
        }
        Media media = mediaOptional.get();
        media.getGeoObject().getMediaSet().remove(media);
        mediaRepository.delete(media);
    }



}
