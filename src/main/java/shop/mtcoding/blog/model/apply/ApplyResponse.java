package shop.mtcoding.blog.model.apply;

import lombok.Data;
import shop.mtcoding.blog.model.resume.Resume;
import shop.mtcoding.blog.model.skill.SkillRequest;

import java.util.List;

public class ApplyResponse {

    @Data
    public static class ApplyResumeDTO{
        private Integer id;
        private String isPass;
        private Integer jobsId;
        private ResumeDTO resume;
    }

    @Data
    public static class ResumeDTO {
        private Integer id;
        private String title;

    }

    @Data
    public static class ApplyByJobsDTO{
        private Integer id;
        private String myName;
        private String title;
        private String career;
        private Integer jobsId;
        private List<SkillRequest.ApplyskillDTO> skillList;

        public ApplyByJobsDTO(Integer id, String myName, String title, String career, Integer jobsId) {
            this.id = id;
            this.myName = myName;
            this.title = title;
            this.career = career;
            this.jobsId = jobsId;
        }
    }
}
