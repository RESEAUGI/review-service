package com.review;

import com.review.model.Review;
import com.review.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}
	/*@Bean
	ApplicationRunner runner (PulsarTemplate<String> pulsarTemplate){
		return args -> pulsarTemplate.send("hello-pulsar-topic","Hello Pulsar World!");
	}

	@PulsarListener(subscriptionName = "hello-pulsar-sub",topics = "hello-pulsar-topic")
	void listen(String message){
		System.out.println("Message Received: "+message);
	}*/
	@Bean
	public CommandLineRunner commandLineRunner(ReviewRepository reviewRepository){
		return args -> {
			reviewRepository.deleteAll();
			Review comment1 = new Review(UUID.randomUUID(),2,"Hello, i am the first comment"
			,new Date(),new Date(),45);
			Review comment2 = new Review(UUID.randomUUID(),2,"Hello, i am the second comment"
					,new Date(),new Date(),24);
			Review comment3 = new Review(UUID.randomUUID(),4,"Hello, i am the third comment"
					,new Date(),new Date(),154);
			reviewRepository.save(comment1);
			reviewRepository.save(comment2);
			reviewRepository.save(comment3);
			reviewRepository.findAll().forEach(review->{
				System.out.println(review.getReviewId());
				System.out.println(review.getContent());
				System.out.println(review.getNb_likes());
			});
		};
	}
}
