# Storing-passwords
Secure ways to store passwords on your database-
Using Salted MD5/SHA-256/SHA-512 is not secure because MD5 weakness is that it's fast which means the attacker can try billions of permutations per second.
This is the reason we should use slow hashing algorithms like PBKDF2/bcrypt, this makes brute force attack too slow to be useful
