package com.kenn.project_crud.mapper;

import com.kenn.project_crud.model.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("""
        <script>
            SELECT p.*, d.dept_id, d.dept_name
            FROM project p
            LEFT JOIN dept d ON p.dept_id = d.dept_id
            <where>
                <if test='search != null and search != ""'>
                    AND (
                        p.project_name LIKE #{search}
                        OR d.dept_name LIKE #{search}
                        OR p.difficulty LIKE #{search}
                    )
                </if>
            </where>
            LIMIT #{pageSize} OFFSET #{offset}
        </script>
    """)
    @ResultMap("com.kenn.project_crud.mapper.ProjectMapper.ProjectResultMap")
    List<Project> findAll(@Param("search") String search,
                          @Param("offset") int offset,
                          @Param("pageSize") int pageSize);

    @Select("""
        <script>
            SELECT COUNT(*) FROM project p
            LEFT JOIN dept d ON p.dept_id = d.dept_id
            <where>
                <if test='search != null and search != ""'>
                    AND (
                        p.project_name LIKE #{search}
                        OR d.dept_name LIKE #{search}
                        OR p.difficulty LIKE #{search}
                    )
                </if>
            </where>
        </script>
    """)
    int countProjects(@Param("search") String search);
}



