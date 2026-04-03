package com.fifteen.mappers;

import com.fifteen.domain.AdminBank;
import com.fifteen.dto.AdminBankDto;
import jdk.nashorn.internal.ir.CallNode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminBankDtoMappers {

    AdminBankDtoMappers INSTANCE = Mappers.getMapper(AdminBankDtoMappers.class);

    AdminBank toConvertEntity(AdminBankDto source);

    AdminBankDto toConvertDto(AdminBank source);

    List<AdminBankDto> toConvertDto(List<AdminBank> source);

    List<AdminBank> toConvertEntity(List<AdminBankDto> source);
}
