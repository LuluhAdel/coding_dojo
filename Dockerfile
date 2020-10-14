ARG BASE_IMAGE=alpine
ARG ALPINE_VERSION=3.10
FROM ${BASE_IMAGE}:${ALPINE_VERSION}
LABEL org.label-schema.schema-version="1.0.0" \
    maintainer="an25081981@gmail.com" \
    org.label-schema.vcs-description="Alpline lalsalamah" \
    org.label-schema.docker.cmd="docker exec " \
    image-size="71.6MB" \
    ram-usage="13.2MB to 70MB" \
    cpu-usage="Low"


RUN apk add --update python3 libcap  && \
	if [ ! -e /usr/bin/python ]; then ln -sf python3 /usr/bin/python ; fi && \
    \
    echo "**** install pip ****" && \
    /usr/bin/python3 -m ensurepip && \
    pip3 install --no-cache --upgrade pip setuptools wheel && \
    if [ ! -e /usr/bin/pip ]; then ln -s pip3 /usr/bin/pip ; fi && \
    pip install  lalsalamah click-man && \
    mkdir /opt/www && \
    addgroup -g 101 -S lalsalamah  && \
    adduser -S -D -H -u 101 -h /opt/www -s /sbin/nologin -G lalsalamah -g lalsalamah lalsalamah && \
    chown -R lalsalamah:lalsalamah /opt/www && \ 
    setcap 'cap_net_bind_service=+ep' /usr/bin/lalsalamah && \
    rm -rf /tmp/* /var/cache/apk/*

VOLUME /var/lalsalamah

USER lalsalamah

COPY docker-entrypoint.sh /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
WORKDIR /var/lalsalamah
EXPOSE 8000
CMD ["lalsalamah"]
