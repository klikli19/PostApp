package com.example.postapp.mapper;

import com.example.postapp.dto.PostalItemsDTO;
import com.example.postapp.model.PostalItems;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public abstract class MappingPostalItems {

    public abstract PostalItemsDTO mapToProductDto(PostalItems postalItems);
}
