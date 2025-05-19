package com.example.repository;

import com.example.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    NamedParameterJdbcTemplate template;

    private static final RowMapper<Member> MEMBER_ROW_MAPPER =
            (rs, i) ->{
        Member member = new Member();
        member.setId(rs.getInt("id"));
        member.setName(rs.getString("name"));
        member.setAge((Integer) rs.getObject("age"));
        member.setDepId((Integer) rs.getObject("dep_id"));
        return member;
            };

    public List<Member> findByName(String partOfName){
        String sql = "SELECT * FROM members WHERE name LIKE :name";
        SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + partOfName + "%");
        return template.query(sql, param, MEMBER_ROW_MAPPER);
    }

}
