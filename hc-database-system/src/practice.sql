#
# Nth Highest Salary in MySQL
#
SELECT Salary FROM Employee
ORDER BY Salary DESC LIMIT n-1,1

#
#
#
SELECT * /*This is the outer query part */
FROM Employee Emp1
WHERE (N-1) = ( /* Subquery starts here */
SELECT COUNT(DISTINCT(Emp2.Salary))
FROM Employee Emp2
WHERE Emp2.Salary > Emp1.Salary)

#
#### Find the nth highest salary in Oracle using rownum
#
select * from (
  select Emp.*, row_number() over (order by Salary DESC) rownumb from Employee Emp
) where rownumb = n;  /*n is nth highest salary*/


#
#### Find the nth highest salary in Oracle using RANK
#

select * FROM (
    select EmployeeID, Salary,rank() over (order by Salary DESC) ranking
from Employee ) WHERE ranking = N;