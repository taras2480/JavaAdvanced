package ua.lviv.lgs.one_to_many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("/META-INF/hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();

		Post post1 = new Post();
		post1.setTittle("Post1");

		Post post2 = new Post();
		post2.setTittle("Post2");

		Comment comment1 = new Comment();
		comment1.setAuthorName("Author1");
		comment1.setPost(post1);

		Comment comment2 = new Comment();
		comment2.setAuthorName("Author2");
		comment2.setPost(post1);

		Comment comment3 = new Comment();
		comment3.setAuthorName("Author3");
		comment3.setPost(post2);

		Comment comment4 = new Comment();
		comment4.setAuthorName("Author4");
		comment4.setPost(post2);

		Set<Comment> comments = new HashSet<Comment>();
		comments.add(comment1);
		comments.add(comment2);
		post1.setComments(comments);

		// save to DB
		Transaction transaction = session.beginTransaction();
		session.save(post1);
		transaction.commit();
		
		
		// read from DB
		Post postDB = (Post) session.get(Post.class, 1);
		System.out.println(postDB + "---->" + postDB.getComments());

		Comment commentDB = (Comment) session.get(Comment.class, 2);
		System.out.println(commentDB + "---->" + commentDB.getPost());

	}

}
