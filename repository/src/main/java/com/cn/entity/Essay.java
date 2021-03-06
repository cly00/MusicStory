package com.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 文章表实体
 *
 * @author chen
 * @date 2017-12-30 17:39
 */
@Setter
@Getter
@Entity
@Table(name = "essay")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Essay extends AbstractDateAudit {
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "uuid")
    @Column(name="id")
    private String id;
    @Column(nullable = false)
    private String title;      //文章标题
    private String synopsis;   //简介
    private String content;    //文章内容
    @Column(columnDefinition = "int default 0",nullable = false)
    private Integer readNum;   //阅览数
    private Byte state;        //状态 0-草稿 1-待审核 2-审核不通过 3-正常 4-推荐
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classifyId",nullable = false)
    private Classify classify;
    private String remark;   //审核不通过原由

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "essayId")
    private List<Music> musicList;

}
