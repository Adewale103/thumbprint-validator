# thumbprint-validator
Thumbprint authentication is a type of client authentication where the client presents a digital certificate (usually an X.509 certificate) to the server for authentication. The server then calculates a thumbprint of the client's public key and compares it to a pre-defined thumbprint to authenticate the client.

To implement the ThumbprintUtils.calculateThumbprint() method, the java.security.MessageDigest class was used to calculate the SHA-256 hash of the client's public key, and then encode the hash as a hexadecimal string.
