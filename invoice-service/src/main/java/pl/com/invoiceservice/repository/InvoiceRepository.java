package pl.com.invoiceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.invoiceservice.model.InvoiceEntity;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

	Optional<InvoiceEntity> findByInvoiceFileName(String invoiceFileName);


}
