package program.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import program.store.model.Pack;
import program.store.repository.repository_pack.IPackRepository;
import program.store.service.IPackService;

public class PackServiceImpl implements IPackService {
    @Autowired
    private IPackRepository iPackRepository;

}
