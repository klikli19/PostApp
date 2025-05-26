package com.example.postapp.mapper;

import com.example.postapp.dto.PostOfficeDTO;
import com.example.postapp.model.PostOffice;
import org.springframework.stereotype.Component;

@Component
public class MappingPostalOffice {

    public PostOfficeDTO mapToDTO(PostOffice office){
        PostOfficeDTO postOfficeDTO = new PostOfficeDTO();
        postOfficeDTO.setId(office.getId());
        postOfficeDTO.setIndex(office.getIndex());
        postOfficeDTO.setName(office.getName());
        postOfficeDTO.setAddress(office.getAddress());
        return postOfficeDTO;
    }
}
