// Users with properties
CREATE (a:User {name:'Alice', age:25, city:'Hyderabad'})
CREATE (b:User {name:'Bob', age:27, city:'Hyderabad'})
CREATE (c:User {name:'Charlie', age:30, city:'Delhi'})
CREATE (d:User {name:'David', age:28, city:'Mumbai'})
CREATE (e:User {name:'Emma', age:26, city:'Chennai'})
CREATE (f:User {name:'Frank', age:32, city:'Bangalore'})
CREATE (g:User {name:'Grace', age:29, city:'Hyderabad'})

// Friendships (bidirectional)
CREATE (a)-[:FRIEND]->(b)
CREATE (b)-[:FRIEND]->(a)

CREATE (b)-[:FRIEND]->(c)
CREATE (c)-[:FRIEND]->(b)

CREATE (c)-[:FRIEND]->(d)
CREATE (d)-[:FRIEND]->(c)

CREATE (d)-[:FRIEND]->(e)
CREATE (e)-[:FRIEND]->(d)

CREATE (e)-[:FRIEND]->(f)
CREATE (f)-[:FRIEND]->(e)

CREATE (f)-[:FRIEND]->(g)
CREATE (g)-[:FRIEND]->(f)

CREATE (g)-[:FRIEND]->(a)
CREATE (a)-[:FRIEND]->(g)

// Extra cross-links
CREATE (b)-[:FRIEND]->(e)
CREATE (e)-[:FRIEND]->(b)

CREATE (c)-[:FRIEND]->(g)
CREATE (g)-[:FRIEND]->(c)
