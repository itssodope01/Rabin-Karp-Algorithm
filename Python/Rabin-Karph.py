def find_suspicious_points(T, P, q):
    n = len(T)
    m = len(P)
    d = 10  
   
    hash_p = 0
    for i in range(m):
        digit = int(P[i])
        hash_p = (hash_p * d + digit) % q

    
    h = 0
    hp = 0

   
    for i in range(m):
        digit_t = int(T[i])
        digit_p = int(P[i])
        h = (h * d + digit_t) % q
        hp = (hp * d + digit_p) % q

    suspicious_points = []

    for i in range(n - m + 1):
        if h == hp:
            
            if T[i:i+m] == P:
                suspicious_points.append(i)

        if i < n - m:
            
            digit_prev = int(T[i])
            digit_next = int(T[i + m])
            h = ((h - digit_prev * (d**(m - 1))) * d + digit_next) % q

    return suspicious_points



T = "31415926535"
P = "26"
q = 11

suspicious_points = find_suspicious_points(T, P, q)
pattern_position = [i for i in range(len(T)) if T.startswith(P, i)]  

print("Suspicious points:", suspicious_points)
print("Pattern position:", pattern_position)
