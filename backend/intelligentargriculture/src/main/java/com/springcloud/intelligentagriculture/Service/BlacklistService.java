package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.Blacklist;
import com.springcloud.intelligentagriculture.repository.BlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlacklistService
{
    @Autowired
    BlacklistRepository repository;

    public List<Blacklist> getAllBlacklists(Integer pageNo, Integer pageSize, String sortBy, int blacklistType, int townId)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Blacklist> pagedResult = null;
        try{
            pagedResult = repository.findAllBySearch(paging, blacklistType, townId);
        }
        catch (Exception e){
            return new ArrayList<Blacklist>();
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Blacklist>();
        }
    }

}