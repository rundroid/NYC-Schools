package com.learning.nycschools.api.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SchoolData(
    @SerialName("academicopportunities1")
    val academicopportunities1: String? = null,
    @SerialName("academicopportunities2")
    val academicopportunities2: String? = null,
    @SerialName("academicopportunities3")
    val academicopportunities3: String? = null,
    @SerialName("academicopportunities4")
    val academicopportunities4: String? = null,
    @SerialName("academicopportunities5")
    val academicopportunities5: String? = null,
    @SerialName("admissionspriority11")
    val admissionspriority11: String? = null,
    @SerialName("admissionspriority12")
    val admissionspriority12: String? = null,
    @SerialName("advancedplacement_courses")
    val advancedplacementCourses: String? = null,
    @SerialName("attendance_rate")
    val attendanceRate: String? = null,
    @SerialName("bbl")
    val bbl: String? = null,
    @SerialName("bin")
    val bin: String? = null,
    @SerialName("boro")
    val boro: String? = null,
    @SerialName("borough")
    val borough: String? = null,
    @SerialName("building_code")
    val buildingCode: String? = null,
    @SerialName("bus")
    val bus: String? = null,
    @SerialName("campus_name")
    val campusName: String? = null,
    @SerialName("census_tract")
    val censusTract: String? = null,
    @SerialName("city")
    val city: String? = null,
    @SerialName("code1")
    val code1: String? = null,
    @SerialName("code2")
    val code2: String? = null,
    @SerialName("college_career_rate")
    val collegeCareerRate: String? = null,
    @SerialName("community_board")
    val communityBoard: String? = null,
    @SerialName("council_district")
    val councilDistrict: String? = null,
    @SerialName("dbn")
    val dbn: String? = null,
    @SerialName("diplomaendorsements")
    val diplomaendorsements: String? = null,
    @SerialName("ell_programs")
    val ellPrograms: String? = null,
    @SerialName("end_time")
    val endTime: String? = null,
    @SerialName("extracurricular_activities")
    val extracurricularActivities: String? = null,
    @SerialName("fax_number")
    val faxNumber: String? = null,
    @SerialName("finalgrades")
    val finalgrades: String? = null,
    @SerialName("grade9geapplicants1")
    val grade9geapplicants1: String? = null,
    @SerialName("grade9geapplicants2")
    val grade9geapplicants2: String? = null,
    @SerialName("grade9geapplicantsperseat1")
    val grade9geapplicantsperseat1: String? = null,
    @SerialName("grade9geapplicantsperseat2")
    val grade9geapplicantsperseat2: String? = null,
    @SerialName("grade9gefilledflag1")
    val grade9gefilledflag1: String? = null,
    @SerialName("grade9gefilledflag2")
    val grade9gefilledflag2: String? = null,
    @SerialName("grade9swdapplicants1")
    val grade9swdapplicants1: String? = null,
    @SerialName("grade9swdapplicants2")
    val grade9swdapplicants2: String? = null,
    @SerialName("grade9swdapplicantsperseat1")
    val grade9swdapplicantsperseat1: String? = null,
    @SerialName("grade9swdapplicantsperseat2")
    val grade9swdapplicantsperseat2: String? = null,
    @SerialName("grade9swdfilledflag1")
    val grade9swdfilledflag1: String? = null,
    @SerialName("grade9swdfilledflag2")
    val grade9swdfilledflag2: String? = null,
    @SerialName("grades2018")
    val grades2018: String? = null,
    @SerialName("graduation_rate")
    val graduationRate: String? = null,
    @SerialName("interest1")
    val interest1: String? = null,
    @SerialName("interest2")
    val interest2: String? = null,
    @SerialName("language_classes")
    val languageClasses: String? = null,
    @SerialName("latitude")
    val latitude: String? = null,
    @SerialName("location")
    val location: String? = null,
    @SerialName("longitude")
    val longitude: String? = null,
    @SerialName("method1")
    val method1: String? = null,
    @SerialName("method2")
    val method2: String? = null,
    @SerialName("neighborhood")
    val neighborhood: String? = null,
    @SerialName("nta")
    val nta: String? = null,
    @SerialName("overview_paragraph")
    val overviewParagraph: String? = null,
    @SerialName("pct_stu_enough_variety")
    val pctStuEnoughVariety: String? = null,
    @SerialName("pct_stu_safe")
    val pctStuSafe: String? = null,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("prgdesc1")
    val prgdesc1: String? = null,
    @SerialName("prgdesc2")
    val prgdesc2: String? = null,
    @SerialName("primary_address_line_1")
    val primaryAddressLine1: String? = null,
    @SerialName("program1")
    val program1: String? = null,
    @SerialName("program2")
    val program2: String? = null,
    @SerialName("psal_sports_boys")
    val psalSportsBoys: String? = null,
    @SerialName("psal_sports_coed")
    val psalSportsCoed: String? = null,
    @SerialName("psal_sports_girls")
    val psalSportsGirls: String? = null,
    @SerialName("school_10th_seats")
    val school10thSeats: String? = null,
    @SerialName("school_accessibility_description")
    val schoolAccessibilityDescription: String? = null,
    @SerialName("school_email")
    val schoolEmail: String? = null,
    @SerialName("school_name")
    val schoolName: String? = null,
    @SerialName("seats101")
    val seats101: String? = null,
    @SerialName("seats102")
    val seats102: String? = null,
    @SerialName("seats9ge1")
    val seats9ge1: String? = null,
    @SerialName("seats9ge2")
    val seats9ge2: String? = null,
    @SerialName("seats9swd1")
    val seats9swd1: String? = null,
    @SerialName("seats9swd2")
    val seats9swd2: String? = null,
    @SerialName("shared_space")
    val sharedSpace: String? = null,
    @SerialName("start_time")
    val startTime: String? = null,
    @SerialName("state_code")
    val stateCode: String? = null,
    @SerialName("subway")
    val subway: String? = null,
    @SerialName("total_students")
    val totalStudents: String? = null,
    @SerialName("website")
    val website: String? = null,
    @SerialName("zip")
    val zip: String? = null
)

