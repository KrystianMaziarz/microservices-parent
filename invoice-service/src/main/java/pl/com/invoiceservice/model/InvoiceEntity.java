package pl.com.invoiceservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "invoice")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String invoiceID;
	private String clientID;
	private String nip; //czy międzynarodowo NIP
	private LocalDateTime createdDate;
	private String invoiceFileName;

}
