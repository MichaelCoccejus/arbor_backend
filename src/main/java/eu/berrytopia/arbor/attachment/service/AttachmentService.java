package eu.berrytopia.arbor.attachment.service;


import eu.berrytopia.arbor.attachment.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
}
