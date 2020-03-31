package com.swap.mani.integration.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class ManiAddressMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long mapId;
		private Long maniId;
		private String address;
		
		public ManiAddressMapping() {
			super();
		}

		public ManiAddressMapping(Long mapId, Long maniId, String address) {
			super();
			this.mapId = mapId;
			this.maniId = maniId;
			this.address = address;
		}
		
		
}
