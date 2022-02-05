package unittest.ch07

/**
 * 스펙
 * 1. 사용자 이메일이 회사 도메인에 속한 경우, 해당 사용자는 직원으로 표시된다. else 고객
 * 2. 시스템은 회사의 직원 수를 추적해야한다. (사용자 유형이 직원 -> 고객 그 반대로 변경되면 이 숫자도 변경해야한다.)
 * 3. 이메일이 변경되면 외부 시스템에 알려야한다.
 */
class User(var userId: String, var email: String, var userType: UserType) {
    fun changeEmail(userId: Int, newEmail: String) {
        // val data = DataBase.getUserById(userId)
        val data: Array<Any?> = arrayOf("email", UserType.EMPLOYEE)

        val email = data[0]
        val userType:UserType = data[1] as? UserType ?: UserType.CUSTOMER

        if (email == null) {
            return
        }

        //val companyData = Database.getCompany()
        val companyData:Array<Any> = arrayOf("www.naver.com",10)

        val companyDomainName  = companyData[0]
        val numberOfEmployees:Int = companyData[1] as? Int ?: 0

        val emailDomain = newEmail.split("@")[1]
        val isEmailCorporate = emailDomain == companyDomainName
        val newType:UserType = if(isEmailCorporate) UserType.EMPLOYEE else UserType.CUSTOMER
        if( userType != newType) {
            val delta:Int = if(newType == UserType.EMPLOYEE) 1 else -1
            val newNumber = numberOfEmployees + delta
            // db saveCompany(newNumber)
        }

        this.email = newEmail
        this.userType = newType

        // db saveUser
        // messageBus.sendEmailChangedMessage
    }
}


enum class UserType(val type: Int) {
    CUSTOMER(1),
    EMPLOYEE(2)
    ;
}