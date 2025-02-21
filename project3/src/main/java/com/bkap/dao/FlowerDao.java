package com.bkap.dao;

import java.util.List;

import com.bkap.entities.Flower;

public interface FlowerDao {
	public List<Flower> getAll();
	public Flower getById(String flowerid);
	public boolean insert(Flower f);
	public boolean update(Flower f);
	public boolean delete(String flowerid);
}
