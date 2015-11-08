package org.gitmining.service;

import java.util.List;

import org.gitmining.bean.SimpleRepo;

public interface RepoDataService {
	public List<SimpleRepo> searchRepo(String name);
}
