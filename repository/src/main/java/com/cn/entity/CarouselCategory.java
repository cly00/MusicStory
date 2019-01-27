package com.cn.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 轮播图分类实体
 */
@Data
@Entity
@Table(name = "carousel_category")
public class CarouselCategory extends UserDateAudit {
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "uuid")
    @Column(name="id")
    private String id;
    private String title;  //标题名称
    private String remark; //描述
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId",nullable = false)
    private List<Carousel> carousels;
}