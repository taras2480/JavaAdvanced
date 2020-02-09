package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.BucketDAO;
import ua.lviv.lgs.dao.impl.BucketDaoImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.service.BucketService;

public class BucketServiceImpl implements BucketService {

	private BucketDAO bucketDAO;

	public BucketServiceImpl() {

		try {
			bucketDAO = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public Bucket create(Bucket t) {

		return bucketDAO.create(t);
	}

	@Override
	public Bucket read(Integer id) {

		return bucketDAO.read(id);
	}

	@Override
	public Bucket update(Bucket t) {

		return bucketDAO.update(t);
	}

	@Override
	public void delete(Integer id) {
		bucketDAO.delete(id);

	}

	@Override
	public List<Bucket> readAll() {

		return bucketDAO.readAll();
	}

}
