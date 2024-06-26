package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.University;
import org.mybatis.cdi.Mapper;

@Mapper
public interface UniversityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    int insert(University record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    University selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    List<University> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    int updateByPrimaryKey(University record);
}