package com.example.Restful.Repository.Impl;

import com.example.Restful.Entity.StudentEntity;
import com.example.Restful.Repository.IStudentRepository;
import com.example.Restful.Utils.NumberUtils;
import com.example.Restful.Utils.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
@Log4j2
public class StudentRepository implements IStudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addStudent(StudentEntity student) {
        try{
            //Dùng try/catch để khi có lỗi xử lý trong phương thức này thì sẽ hiển thị thông báo
            // lên log để hỗ trợ tìm lỗi cách nhanh nhất để xử lý
            entityManager.persist(student);
        } catch (Exception e){
            log.info("Exception: ", e);
        }
    }

    @Override
    public StudentEntity findById(Integer id) {
        try{
            return entityManager.find(StudentEntity.class, id);
        } catch (Exception e) {
            log.info("Exception: ", e);
        }
        return null;
    }


    @Override
    public void update(StudentEntity student) {
        try {
            entityManager.merge(student);
        } catch (Exception e) {
            log.info("Exception", e);
        }
    }

    public void delete(StudentEntity student) {
        try {
            entityManager.remove(student);
        } catch (Exception e) {
            log.info("Exception: ", e);
        }
    }

    @Override
    public List<StudentEntity> findStudentsWithBirthday(LocalDate birthday) {
        try{
            String sql = "SELECT s FROM StudentEntity s WHERE DAY(s.birthday) = :day AND MONTH(s.birthday) = :month";
            Query query = entityManager.createQuery(sql);
            query.setParameter("day", birthday.getDayOfMonth());
            query.setParameter("month", birthday.getMonthValue());
            return query.getResultList();
        } catch (Exception e) {
            log.info("Exception: ", e);
        }
        return null;
    }

    private void joinTable(Map<String, String> search, StringBuilder sql) {
        String majorName = search.get("majorName");
        if(StringUtils.checkString(majorName)) {
            sql.append(" JOIN major AS m ON s.major_id = m.id ");
        }
        String className = search.get("className");
        if(StringUtils.checkString(className)) {
            sql.append(" JOIN student_class AS sc ON s.id = sc.student_id ");
            sql.append(" JOIN class AS c ON sc.class_id = c.id ");
        }
    }

    public static void queryNormal(StringBuilder sql, Map<String, String> conditions){
        for(Map.Entry<String, String> item : conditions.entrySet()){
            if(!item.getKey().equals("majorName") && !item.getKey().equals("className") && !item.getKey().equals("page") && !item.getKey().equals("pageSize")
                    && !item.getKey().startsWith("avg")){
                String value = item.getValue();
                if(StringUtils.checkString(value)){
                    if(NumberUtils.checkNumber(value)){
                        sql.append("AND s." + item.getKey() + " = " + value + " ");
                    }
                    else{
                        sql.append("AND s." + item.getKey() + " LIKE '%" + item.getValue() + "%' ");
                    }
                }
            }
        }
    }

    public static void querySpecial(StringBuilder sql, Map<String, String> search) {
        String avgMin = search.get("avgMin");
        String avgMax = search.get("avgMax");
        if (StringUtils.checkString(avgMin) || StringUtils.checkString(avgMax)) {
            if(StringUtils.checkString(avgMin)) {
                sql.append(" AND s.avg >= " + avgMin + " ");
            }
            if (StringUtils.checkString(avgMax)) {
                sql.append(" AND s.avg <= " + avgMax + " ");
            }
        }
        String majorName = search.get("majorName");
        if(StringUtils.checkString(majorName)){
            sql.append(" AND m.major_name = '" + majorName + "' ");
        }
        String className = search.get("className");
        if(StringUtils.checkString(className)){
            sql.append(" AND c.class_name = '" + className + "' ");
        }
    }

    @Override
    public List<StudentEntity> findAllStudents(Map<String, String> search, Pageable pageable) {
        try {
            StringBuilder sql = new StringBuilder("SELECT s.* FROM student s ");
            joinTable(search, sql);
            sql.append("WHERE 1 = 1 ");
            queryNormal(sql, search);
            querySpecial(sql, search);
            sql.append(" GROUP BY s.id");
            sql.append(" LIMIT ").append(pageable.getPageSize())
                    .append(" OFFSET ").append(pageable.getOffset() );
            Query query = entityManager.createNativeQuery(sql.toString(), StudentEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            log.info("Exception: ", e);
        }
        return null;
    }

}
