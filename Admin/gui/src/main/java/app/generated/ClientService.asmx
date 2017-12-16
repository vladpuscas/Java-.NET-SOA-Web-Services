<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempuri.org/" xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" targetNamespace="http://tempuri.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
      <s:element name="login">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="loginResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="loginResult" type="tns:Client" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="Client">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="id" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="role" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="searchPackage">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="id" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="searchPackageResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="searchPackageResult" type="tns:Package" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="Package">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="id" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="sender_id" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="receiver_id" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="name" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="description" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="senderCity" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="destinationCity" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="tracking" type="s:boolean" />
        </s:sequence>
      </s:complexType>
      <s:element name="getRoutes">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="id" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getRoutesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getRoutesResult" type="tns:ArrayOfRoute" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfRoute">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="Route" nillable="true" type="tns:Route" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="Route">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="id" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="packageId" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="city" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="time" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="register">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="registerResponse">
        <s:complexType />
      </s:element>
      <s:element name="getPackages">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="id" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getPackagesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getPackagesResult" type="tns:ArrayOfPackage" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfPackage">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="Package" nillable="true" type="tns:Package" />
        </s:sequence>
      </s:complexType>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="loginSoapIn">
    <wsdl:part name="parameters" element="tns:login" />
  </wsdl:message>
  <wsdl:message name="loginSoapOut">
    <wsdl:part name="parameters" element="tns:loginResponse" />
  </wsdl:message>
  <wsdl:message name="searchPackageSoapIn">
    <wsdl:part name="parameters" element="tns:searchPackage" />
  </wsdl:message>
  <wsdl:message name="searchPackageSoapOut">
    <wsdl:part name="parameters" element="tns:searchPackageResponse" />
  </wsdl:message>
  <wsdl:message name="getRoutesSoapIn">
    <wsdl:part name="parameters" element="tns:getRoutes" />
  </wsdl:message>
  <wsdl:message name="getRoutesSoapOut">
    <wsdl:part name="parameters" element="tns:getRoutesResponse" />
  </wsdl:message>
  <wsdl:message name="registerSoapIn">
    <wsdl:part name="parameters" element="tns:register" />
  </wsdl:message>
  <wsdl:message name="registerSoapOut">
    <wsdl:part name="parameters" element="tns:registerResponse" />
  </wsdl:message>
  <wsdl:message name="getPackagesSoapIn">
    <wsdl:part name="parameters" element="tns:getPackages" />
  </wsdl:message>
  <wsdl:message name="getPackagesSoapOut">
    <wsdl:part name="parameters" element="tns:getPackagesResponse" />
  </wsdl:message>
  <wsdl:portType name="ClientServiceSoap">
    <wsdl:operation name="login">
      <wsdl:input message="tns:loginSoapIn" />
      <wsdl:output message="tns:loginSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="searchPackage">
      <wsdl:input message="tns:searchPackageSoapIn" />
      <wsdl:output message="tns:searchPackageSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getRoutes">
      <wsdl:input message="tns:getRoutesSoapIn" />
      <wsdl:output message="tns:getRoutesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="register">
      <wsdl:input message="tns:registerSoapIn" />
      <wsdl:output message="tns:registerSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getPackages">
      <wsdl:input message="tns:getPackagesSoapIn" />
      <wsdl:output message="tns:getPackagesSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="ClientServiceSoap" type="tns:ClientServiceSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="login">
      <soap:operation soapAction="http://tempuri.org/login" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="searchPackage">
      <soap:operation soapAction="http://tempuri.org/searchPackage" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getRoutes">
      <soap:operation soapAction="http://tempuri.org/getRoutes" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="register">
      <soap:operation soapAction="http://tempuri.org/register" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getPackages">
      <soap:operation soapAction="http://tempuri.org/getPackages" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="ClientServiceSoap12" type="tns:ClientServiceSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="login">
      <soap12:operation soapAction="http://tempuri.org/login" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="searchPackage">
      <soap12:operation soapAction="http://tempuri.org/searchPackage" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getRoutes">
      <soap12:operation soapAction="http://tempuri.org/getRoutes" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="register">
      <soap12:operation soapAction="http://tempuri.org/register" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getPackages">
      <soap12:operation soapAction="http://tempuri.org/getPackages" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="ClientService">
    <wsdl:port name="ClientServiceSoap" binding="tns:ClientServiceSoap">
      <soap:address location="http://localhost:64634/ClientService.asmx" />
    </wsdl:port>
    <wsdl:port name="ClientServiceSoap12" binding="tns:ClientServiceSoap12">
      <soap12:address location="http://localhost:64634/ClientService.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>