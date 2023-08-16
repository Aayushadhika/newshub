//package com.example.online.news.pojo;
//
//import jakarta.persistence.Column;
//
//public class News {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "news_id")
//    private int news_id;
//    @Column(name = "news_title")
//    private String news_title;
//    @Column(name = "news_description")
//    private String news_description;
//    @Column(name = "news_image_path")
//    private String news_image_path;
//    @ManyToOne()
//    @JoinColumn(name = "user_details")
//    private User user_details;
//}
