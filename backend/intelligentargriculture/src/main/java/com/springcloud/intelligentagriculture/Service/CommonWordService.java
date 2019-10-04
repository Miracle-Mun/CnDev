package com.springcloud.intelligentagriculture.Service;

import com.springcloud.intelligentagriculture.model.CommonWord;
import com.springcloud.intelligentagriculture.model.Town;
import com.springcloud.intelligentagriculture.repository.CommonWordRepository;
import com.springcloud.intelligentagriculture.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonWordService
{
    @Autowired
    CommonWordRepository repository;


    public List<CommonWord> getAllWords(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<CommonWord> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<CommonWord>();
        }
    }
}