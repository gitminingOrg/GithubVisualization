package org.gitmining.dao;
import java.util.*;

import org.gitmining.bean.Repository;
import org.gitmining.bean.SimpleRepo;
public interface RepositoryDao {
	public	List<SimpleRepo> searchRepos(String pattern);
	public	Repository getRepositoryById(int id);
	public	Repository getRepositoryByName(String name);
}