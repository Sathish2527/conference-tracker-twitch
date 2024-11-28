package com.manning.sbip.twitch.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Conference {
	@Id
	@GeneratedValue(strategy =  GenerationType. IDENTITY)
	private Long id;
	@NotEmpty(message = "Conference name is required")
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd T'HH:mm")
	private LocalDateTime dateTime;
	@NotEmpty(message = "Conference location is required")
	private String location;
	@NotEmpty (message= "Conference speaker is required")
	private String speaker;
	private boolean status = true;

}
