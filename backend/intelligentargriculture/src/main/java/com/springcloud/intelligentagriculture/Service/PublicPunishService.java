package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.PublicPunish;
import com.springcloud.intelligentagriculture.repository.PublicPunishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicPunishService
{
    @Autowired
    PublicPunishRepository repository;

    public List<PublicPunish> getAllPublicPunishes(Integer pageNo, Integer pageSize, String sortBy, String creditCode)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<PublicPunish> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, creditCode);
        }
        catch (Exception e){
            return new ArrayList<PublicPunish>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<PublicPunish>();
        }
    }

}