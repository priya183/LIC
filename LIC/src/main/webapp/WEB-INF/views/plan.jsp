<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink;">
    <div align="center">
        <h2>Plan Details</h2>
        <form action="planDetails" method="get" >
        <fieldset style="background-color:white;" >
        <table >
      
       <label for="name"></label>Choose a Plan:</label>
       <select name="name" id="planname">
       <option value="LIC_Bima">LIC Bima</option>
       <option value="AYU_Bima">AYU Bima</option>
       <option value="JIVAN_Bima">JIVAN Bima</option>
       </select>
       <br><br>
        
     <label for="monthyInstallment"></label>Monthly Insallment:</label>
     <select name="monthyInstallment" id="monthyInstallment">
     <option value=5000>5000</option>
     <option value=4000>4000</option>
     <option value=1500>1500</option>
     </select>
     <br><br>
    
        <label for="durationPeriod"></label>Duration Period:</label>
        <select name="durationPeriod" id="durationPeriod">
        <option value=10>10</option>
        <option value=15>15</option>
        <option value=20>20</option>
        </select><br><br>
    
    <label for="maturityAmount"></label>Maturity Amount:</label>
    <select name="maturityAmount" id="maturityAmount">
    <option value=1000000>1000000</option>
    <option value=1500000>1500000</option>
    <option value=2000000>2000000</option>
    </select><br><br>
    
    <tr>
    <td>Create Date:</td>
        <td><input type="date" name="createDate" value=<%= new java.util.Date() %>/></td></tr>
       </table>
            <input type="submit" value="Submit"/>
            </fieldset>
        </form>
    </div>

</body>
</html>