# Config pour apache pulsar
-- Démarer les producers en mode exclusive
-- Activer la propriété chunking pour permettre à pulsar de gérer des cas où la taille du message envoyé
dépasse la maxMessageSize (5MB par défaut)
NB: #Chunking is only available for persistent topics.
    #Chunking is only available for the exclusive and failover subscription types.
    #Chunking cannot be enabled simultaneously with batching. Before enabling chunking,
     you need to disable batching.



# Scylla db
## Configure and Run ScyllaDB
### 1- Configure the following parameters in the /etc/scylla/scylla.yaml configuration file.
* `cluster_name` - The name of the cluster. All the nodes in the cluster must have the same cluster name configured.
* `seeds` - The IP address of the first node. Other nodes will use it as the first contact point to discover the cluster topology when joining the cluster.
* `listen_address` - The IP address that ScyllaDB uses to connect to other nodes in the cluster.
* `rpc_address` - The IP address of the interface for client connections (Thrift, CQL).
### 2- Run the scylla_setup script to tune the system settings and determine the optimal configuration.
#### `sudo scylla_setup`
* The script invokes a set of scripts to configure several operating system settings; for example, it sets RAID0 and XFS filesystem.
* The script runs a short (up to a few minutes) benchmark on your storage and generates the /etc/scylla.d/io.conf configuration file. When the file is ready, you can start ScyllaDB. ScyllaDB will not run without XFS or io.conf file.
* You can bypass this check by running ScyllaDB in developer mode. We recommend against enabling developer mode in production environments to ensure ScyllaDB’s maximum performance.

### I chose to use it as developper mode (not good for the production environnement)
#### `sudo scylla_dev_mode_setup --developer-mode 1`
  It will write the developer mode in /etc/scylla.d/dev-mode.conf
### 3- Run ScyllaDB as a service (if not already running).
#### `sudo systemctl start scylla-server`
Now you can start using ScyllaDB. Here are some tools you may find useful.
#### Run nodetool:
`nodetool status`
#### Run cqlsh:
`cqlsh`
#### Run cassandra-stress:
`cassandra-stress write -mode cql3 native`

