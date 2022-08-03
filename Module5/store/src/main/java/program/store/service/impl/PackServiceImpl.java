package program.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import program.store.repository.repository_pack.IPackRepository;
import program.store.service.IPackService;


public class PackServiceImpl implements IPackService {
    @Autowired
    private IPackRepository iPackRepository;

}
