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

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_record")
@SQLDelete(sql = "Update t_record set isDeleted = 1 where id = ?")
@Where(clause = "isDeleted = 0")
public class Record {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column
    private String sqlStatement;
    @Column
    private String executeMessage;
    @Column
    private Date createTime;
    @Column
    private int userId;
    @Column
    private int dbId;
    @Column
    private int executeStatus;
    @Column(name = "isDeleted", columnDefinition = "Bit default '0'")
    int isDeleted;
}
