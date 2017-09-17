package com.zcx.sqlrecord.entity;

/**
 * Created by zhangchengxi on 2017/9/17.
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
@SQLDelete(sql = "Update t_user set isDeleted = 1 where id = ?")
@Where(clause = "isDeleted = 0")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column
    private String account;
    @Column
    private String password;
    @Column(name = "isDeleted", columnDefinition = "Bit default '0'")
    private int isDeleted;
}
