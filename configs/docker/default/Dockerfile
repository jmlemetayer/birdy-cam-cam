FROM	ubuntu:20.04

RUN	set -x \
	# Install the needed package
	&& export DEBIAN_FRONTEND=noninteractive \
	&& apt update \
	&& apt install --no-install-recommends -y \
		build-essential \
		ca-certificates \
		chrpath \
		cpio \
		diffstat \
		fakeroot \
		file \
		gawk \
		git \
		iproute2 \
		iptables \
		locales \
		lz4 \
		make \
		openssh-client \
		python3 \
		python3-distutils \
		qemu \
		wget \
		zstd \
	&& rm -rf /var/lib/apt/lists/* \
	# Configure the locales
	&& localedef -i en_US -c -f UTF-8 en_US.UTF-8

ENV	LANG en_US.utf8
