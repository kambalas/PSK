package lt.vu.mybatis.model;

public class University {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.UNIVERSITY.ID
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.UNIVERSITY.NAME
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.UNIVERSITY.ID
     *
     * @return the value of PUBLIC.UNIVERSITY.ID
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.UNIVERSITY.ID
     *
     * @param id the value for PUBLIC.UNIVERSITY.ID
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.UNIVERSITY.NAME
     *
     * @return the value of PUBLIC.UNIVERSITY.NAME
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.UNIVERSITY.NAME
     *
     * @param name the value for PUBLIC.UNIVERSITY.NAME
     *
     * @mbg.generated Sun Apr 14 19:45:17 EEST 2024
     */
    public void setName(String name) {
        this.name = name;
    }
}