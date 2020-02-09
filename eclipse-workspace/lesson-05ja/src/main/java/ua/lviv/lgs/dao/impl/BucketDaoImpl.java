package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.BucketDAO;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDAO {

	private static String READ_ALL = "select * from bucket";
	private static String CREATE = "insert into bucket(`user_id`, `product_id`,`purcase_date`) values (?,?,?)";
	private static String READ_BY_ID = "select * from bucket where id =?";
	private static String DELETE_BY_ID = "delete from bucket where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public BucketDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();

	}

	@Override
	public Bucket create(Bucket bucket) {
		try {
			preparedStatement = connection.prepareStatement(CREATE,java.sql.Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, bucket.getUser_id());
			preparedStatement.setInt(2, bucket.getProduct_id());
			preparedStatement.setDate(3, new Date(bucket.getPurchase_date().getTime()));
			preparedStatement.executeUpdate();
			
			ResultSet rs=preparedStatement.getGeneratedKeys();
			rs.next();
			bucket.setId(rs.getInt(1));
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			int bucketId = result.getInt("id");
			Integer user_id = result.getInt("user_id");
			Integer product_id = result.getInt("product_id");
			Date purchase_date = result.getDate("purchase_date");

			bucket = new Bucket(bucketId, user_id, product_id, purchase_date);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public Bucket update(Bucket t) {
		throw new IllegalStateException("can't update from bucket");

	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<Bucket> readAll() {
		List<Bucket> bucketRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				int bucketId = result.getInt("id");
				Integer user_id = result.getInt("user_id");
				Integer product_id = result.getInt("product_id");
				Date purchase_date = result.getDate("purchase_date");

				bucketRecords.add(new Bucket(bucketId, user_id, product_id, purchase_date));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bucketRecords;
	}

}
