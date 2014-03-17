
# Command Line Trust Bundle Generator


## Usage

	java -jar TrustBundler.jar <anchordir> <destdir> <name> [-m metadatafile] [-p passkey -c certificate]

anchorDir: location for der files for the trust bundle
destdir: destination directory for the generated trut bundle file
name: name of the trust bundle file
metadatafile: meta data file for the certificates in the anchor directory
passkey, certificate: private key pem file and the associated password for signing the trust bundle
