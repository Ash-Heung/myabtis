package org.apache.ibatis.isiyi.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * blog实体类
 * <p></p>
 *
 * @version 1.0.0
 * @description: BlockEntity
 * @author: 向鹏飞
 * @since: 2021/12/6
 */
@Data
public class ActorEntity {

    private int actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;

}
