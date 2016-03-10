
List of Issues:
- Maybe it's better to have some links implicitly, like: 
    * Company<->Employee




With DataRest:
 - sadly with SpringDataRest you cannot interact so well with the owned side of an assoc. eg:  Company::setEmployees
 - With Eager loading of Collections you might get false multiples shown in the JSON, 
        but its just in the view, so actually there are no real multiples.
        And it doesnt occur everywhere. Probably due to some sort of wrong way to join tables.
 - References always remain even if the referenced resource is deleted and doesnt exist anymore.
    -> Dereferencing would be great.
    -> Cascading is possible.

