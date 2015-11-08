package org.gitmining.dao;
import java.util.*;

import org.gitmining.bean.SimpleRepo;
public interface RepositoryDao {
	public	List<SimpleRepo> searchRepos(String pattern);
}
