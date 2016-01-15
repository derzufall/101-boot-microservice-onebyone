- List of Constraints:

*D*
- The C of a D connot be changed
- 


*E*
- has: C, D, name, S-amount, manages
- D = NULL means default D
- C = NULL means default C (available)
- ON DELETE: All Ss of an E wil be cascaded
- ON DELETE: manages of all linked Ds will be NULLed
- ON CREATE: A S for the E will be created
- ON CHANGE: If S-amount changes, a new S will be created

*T*
- 



*S*
- has: E, amount, Date
- Amount cannot be changed
- E cannot be changed
- 