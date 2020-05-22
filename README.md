# Storing-passwords
Even using salted MD5/SHA-256/SHA-512 is not secure because their weakness is that it's fast which means the attacker can try billions of permutations per second.
This is the reason we should use slow hashing algorithms like PBKDF2/bcrypt, this makes brute force attack too slow to be useful

This project generates hashes using salted MD5 and PBKDF2, implementation is in Java using java.security & java.crypto packages.
