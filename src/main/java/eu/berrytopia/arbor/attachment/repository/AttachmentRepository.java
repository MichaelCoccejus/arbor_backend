package eu.berrytopia.arbor.attachment.repository;


import eu.berrytopia.arbor.attachment.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}
