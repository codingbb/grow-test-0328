package shop.mtcoding.blog.model.jobs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.blog.model.apply.Apply;
import shop.mtcoding.blog.model.resume.Resume;

import java.util.List;


public interface JobsJPARepository extends JpaRepository <Jobs, Integer> {

    //select * from apply_tb a join jobs_tb j on a.jobs_id = j.id where a.resume_id = 1;
    @Query("select j from Apply a join fetch Jobs j on a.jobs.id = j.id where a.resume.id = :resumeId")
    List<Apply> findAllByJobsIdAndUserId(@Param("resumeId") Integer resumeId);

    //Apply에서 resume_id가 1인 공고 모두 조회

    @Query("select j from Jobs j where j.user.id = :userId")
    List<Jobs> findAllByUserId(@Param("userId") Integer userId);

}
