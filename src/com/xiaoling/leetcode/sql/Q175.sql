SELECT p.FirstName, p.LastName, a.City, a.State
FROM Person p
LEFT JOIN Address a on a.PersonId = p.PersonId